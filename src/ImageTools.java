
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTools {

    public static int HORIZONTAL_FLIP = 1, VERTICAL_FLIP = 2, DOUBLE_FLIP = 3;

    /**
     * Loads an image.
     *
     * @param fileName The name of a file with an image
     * @return Returns the loaded image. null is returned if the image cannot be loaded.
     */
    public static BufferedImage load(String fileName) {
        try {
            return ImageIO.read((new File(fileName)));
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Copies and returns an image.
     *
     * @param img Receives a buffered image
     * @return Returns a copy of the received image. null is returned if the received image is null.
     */
    public static BufferedImage copy(BufferedImage img) {
        if (img == null) {
            return null;
        }
        ColorModel cm = img.getColorModel();
        WritableRaster raster = img.copyData(null);
        return new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);
    }

    /**
     * Returns a new image with transparency enabled.
     *
     * @param img Receives a buffered image
     * @return returns a copy of the received image with a color mode that allows transparency.
     * null is returned if the received image is null.
     */
    public static BufferedImage copyWithTransparency(BufferedImage img) {
        if (img == null) {
            return null;
        }
        BufferedImage temp = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics tempG = temp.getGraphics();
        tempG.drawImage(img, 0, 0, null);
        return temp;
    }

    /**
     * Checks if the provided image has transparency.
     *
     * @param img Receives a buffered image
     * @return returns true if the image has a transparent mode and false otherwise.
     */
    public static boolean hasTransparency(BufferedImage img) {
        return img.getColorModel().hasAlpha();
    }

    /**
     * Scales an image.
     *
     * @param img Receives a buffered image and two positive double scale values (percentages)
     * @param horizontalScale Value to scale horizontal by.
     * @param verticalScale Value to scale vertical by.
     * @return creates and returns a scaled copy of the received image,
     * null is returned if the received image is null or if non-positive scales are provided
     */
    public static BufferedImage scale(BufferedImage img, double horizontalScale,
            double verticalScale) {
        if (img == null) {
            return null;
        }
        BufferedImage temp = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D tempG = temp.createGraphics();
        AffineTransform xform = new AffineTransform();
        xform.setToScale(horizontalScale, verticalScale);

        tempG.drawImage(img, xform, null);
        return temp;
    }

    /**
     * Scales an image.
     *
     * @param img Receives a buffered image
     * @param newWidth New width to scale to.
     * @param newHeight New height to scale to.
     * @return creates and returns a scaled copy of the received image,
     * null is returned if the received image is null or if non-positive dimensions are provided
     */
    public static BufferedImage scale(BufferedImage img, int newWidth,
            int newHeight) {
        if (img == null) {
            return null;
        }
        BufferedImage temp = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D tempG = temp.createGraphics();
        AffineTransform xform = new AffineTransform();
        double currentWidth = img.getWidth(), currentHeight = img.getHeight();
        xform.setToScale(newWidth / currentWidth, newHeight / currentHeight);
        tempG.drawImage(img, xform, null);
        return temp;
    }

    /**
     * Rotates an image.
     *
     * @param img Receives a buffered image
     * @param angle The angle to rotate to.
     * @return The rotated image. null is returned if the received image is null.
     */
    public static BufferedImage rotate(BufferedImage img, double angle) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Flips an image.
     *
     * @param img Receives a buffered image
     * @param type Type of flip (int)
     * @return Creates and returns a flipped copy of the received image.
     * null is returned if the received image is null or if an invalid flipping value is provided
     */
    public static BufferedImage flip(BufferedImage img, int type) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Blurs an image.
     *
     * @param img Receives a buffered image
     * @return creates and returns a blurred copy of the received image,
     * the blurring is created by blending each cell with its 8 neighbors.
     * Null is returned if the received image is null.
     */
    public static BufferedImage blur(BufferedImage img) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Inverts an image's colors.
     *
     * @param img Receives a buffered image
     * @return Image with inverted colors. null is returned if the received image is null.
     */
    public static BufferedImage invertColor(BufferedImage img) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Removes a certain percentage of an image's pixels.
     *
     * @param img Receives a buffered image
     * @param percentToRemove Percent to remove of the image.
     * @return creates and returns a copy of the received image with the given
     * percentage in decimal form of the images remaining non-fully transparent
     * pixels changed to be completely transparent. null is returned if the
     * received image is null or if non-positive percentage is provided.
     */
    public static BufferedImage removePixels(BufferedImage img, double percentToRemove) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Removes a certain amount of pixels from an image.
     *
     * @param img Receives a buffered image
     * @param numToRemove number of pixels to remove
     * @return creates and returns a copy of the received image with the given
     * number of the images remaining pixels removed.
     * Non-fully transparent pixels are changed to be completely transparent.
     * null is returned if the received image is null or if non-positive number
     * is provided. Note: is there are not enough pixels in the image it will
     * remove as many as it can.
     */
    public static BufferedImage removePixels(BufferedImage img, int numToRemove) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Fades an image.
     *
     * @param img Receives a buffered image
     * @param fade Double percentage to fade
     * @return Creates and returns a copy of the received image that has been
     * faded the given percentage. Fading is done by multiply the alpha value by (1-fade)
     * Null is returned if the received image is null or if non-positive fade value is provided
     * Note: any fade greater than 1 will be reduced to 1
     */
    public static BufferedImage fade(BufferedImage img, double fade) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Lightens an image.
     *
     * @param img Receives a buffered image
     * @param lightenFactor double percentage to lighten
     * @return creates and returns a copy of the received image that has been
     * lightened by the given percentage + 1.
     * Null is returned if the received image is null or if non-positive lighten.
     * Factor value is provided.
     * Note: any colors that end up being larger than 255 will be changed to 255.
     */
    public static BufferedImage lighten(BufferedImage img, double lightenFactor) {
        if (img == null) {
            return null;
        }
        return null;
    }

    /**
     * Darkens an image.
     *
     * @param img Receives a buffered image
     * @param darkenFactor double percentage to darken
     * @return creates and returns a copy of the received image that has been
     * darkened by 1 minus the given percentage.
     * null is returned if the received image is null or if non-positive.
     * Note: any colors that end up being larger than 255 will be
     * changed to 255.
     */
    public static BufferedImage darken(BufferedImage img, double darkenFactor) {
        if (img == null) {
            return null;
        }
        return null;
    }
}
