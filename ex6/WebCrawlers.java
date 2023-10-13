import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class WebCrawler implements Runnable {
    private static final int MAX_DEPTH = 2;
    private String url;
    private int depth;
    private Set<String> visitedLinks;
    private ExecutorService executor;
    private AtomicInteger executedThreadCount;

    public WebCrawler(String url, int depth, Set<String> visitedLinks, ExecutorService executor, AtomicInteger executedThreadCount) {
        this.url = url;
        this.depth = depth;
        this.visitedLinks = visitedLinks;
        this.executor = executor;
        this.executedThreadCount = executedThreadCount;
    }

    @Override
    public void run() {
        if (depth > MAX_DEPTH || visitedLinks.contains(url)) {
            return;
        }

        visitedLinks.add(url);

        try {
            Document document = Jsoup.connect(url).get();
            String title = document.title();
            System.out.println("Title of " + url + ": " + title);

            Elements links = document.select("a[href]");
            for (Element link : links) {
                String nextUrl = link.absUrl("href");
                if (!executor.isShutdown()) {
                    executor.execute(new WebCrawler(nextUrl, depth + 1, visitedLinks, executor, executedThreadCount));
                }
            }
        } catch (IOException e) {
            System.err.println("Error crawling " + url + ": " + e.getMessage());
        } finally {
            // Increment the executedThreadCount when the thread finishes
            executedThreadCount.incrementAndGet();
        }
    }
}

public class WebCrawlers {
    public static void main(String[] args) {
        // List of websites to crawl
        String[] websites = {"https://www.shiksha.com/university/anna-university-chennai-3084", "https://google.com", "https://www.flipkart.com/"};

        // Create a thread pool with a fixed number of threads
        int numThreads = 5; // Adjust this based on your needs
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Set to track visited links to avoid revisiting
        Set<String> visitedLinks = new HashSet<>();

        // AtomicInteger to track executed thread count
        AtomicInteger executedThreadCount = new AtomicInteger(0);

        // Start crawling each website concurrently
        for (String website : websites) {
            executor.execute(new WebCrawler(website, 0, visitedLinks, executor, executedThreadCount));
        }

        // Shutdown the executor when crawling is complete
        executor.shutdown();

        try {
            // Wait for all threads to finish
            if (!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                // Handle termination if needed
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print the final count of executed threads
        System.out.println("All websites crawled. Total threads executed: " + executedThreadCount.get());
    }
}
