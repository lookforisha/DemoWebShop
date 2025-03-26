package Base;

public class DriverManager {
	private static ThreadLocal<String> browser = new ThreadLocal<>();

    public static void setThreadBrowser(String browserName) {
        browser.set(browserName);
    }

    public static String getThreadBrowser() {
        return browser.get();
    }

    public static void clear() {
        browser.remove();
    }
}
