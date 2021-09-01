package Jsuite;
import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectPackages("Junit")
public class AllTests {}
