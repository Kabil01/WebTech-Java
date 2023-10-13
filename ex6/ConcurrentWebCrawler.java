import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WebCrawler implements Runnable {
    private String url;
    private Set<String> visitedUrls;
    private int maxDepth;

    public WebCrawler(String url, Set<String> visitedUrls, int maxDepth) {
        this.url = url;
        this.visitedUrls = visitedUrls;
        this.maxDepth = maxDepth;
    }

    @Override
    public void run() {
        if (maxDepth <= 0 || visitedUrls.contains(url)) {
            return;
        }

        // Simulate crawling logic here (e.g., fetching web page content)
        System.out.println("Crawling: " + url);

        visitedUrls.add(url);

        // Extract links from the web page (simulated)
        Set<String> links = extractLinksFromPage(url);

        // Create and submit new threads for each link
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String link : links) {
            executor.execute(new WebCrawler(link, visitedUrls, maxDepth - 1));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Set<String> extractLinksFromPage(String url) {
        // Simulate link extraction logic here (e.g., using a library like Jsoup)
        Set<String> links = new HashSet<>();
        links.add("http://google.com/link1");
        links.add("http://google.com/link2");
        return links;
    }
}

public class ConcurrentWebCrawler {
    public static void main(String[] args) {
        String startingUrl = "http:google.com"; // Replace with your starting URL
        int maxDepth = 2; // Maximum depth to crawl

        Set<String> visitedUrls = new HashSet<>();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new WebCrawler(startingUrl, visitedUrls, maxDepth));

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

