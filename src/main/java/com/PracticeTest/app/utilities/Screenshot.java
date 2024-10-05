package com.PracticeTest.app.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static TakesScreenshot takesScreenshot;

    public static void setupScreenshot(String ScreenshotName) throws IOException {
        System.out.println(ScreenshotName);
       File src =  takesScreenshot.getScreenshotAs(OutputType.FILE);
       File tar = new File("./Screenshot/"+ScreenshotName+".png");
       FileUtils.copyFile(src,tar);
    }
}
