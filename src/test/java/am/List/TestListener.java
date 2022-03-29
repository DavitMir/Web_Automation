package am.List;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class TestListener implements ITestListener {
    static WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        BufferedImage a = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver).getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(a, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(baos.toByteArray()));
    }
}
