package bjs.task21.computers;

import bjs.task21.components.VideoCard;
import java.util.HashMap;

/**
 * Created by YM on 04.12.2015.
 */
public class Laptop extends Computer implements LaptopAccessories {
    /**Describes video card*/
    private VideoCard videoCard;
    /**Display description*/
    private String display;
    /**Audio card*/
    private String audioCard;

    /**Computer accessories.*/
    protected HashMap<AccessoryType, String> accessories;

    public Laptop() {
        videoCard = new VideoCard();
        accessories = new HashMap<AccessoryType, String>();
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += videoCard.toString();
        result += "Display: " + display + "\n";
        result += "Audio card: " + audioCard + "\n";
        result += "Accessories: " + getAccessories() + "\n";
        result += "Price:  " + getPrice() + "\n";

        return result;
    }

    /**
     * Sets video card
     * @param type Card name
     * @param ramSize Card RAM size
     * @param ramType Card RAM type
     */
    public void setVideoCard(String type, double ramSize, String ramType) {
        this.videoCard.setType(type);
        this.videoCard.setRamSize(ramSize);
        this.videoCard.setRamType(ramType);
    }

    /**
     * Sets display
     * @param display Display name and type
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * Sets type of the audio card
     * @param audioCard Type of the audio card
     */
    public void setAudioCard(String audioCard) {
        this.audioCard = audioCard;
    }

    /**
     * Sets the mouse
     * @param mouse
     */
    public void setMouse(String mouse) {
        accessories.put(AccessoryType.MOUSE, mouse);
    }

    /**
     * Sets the headset
     * @param headset
     */
    public void setHeadset(String headset) {
        accessories.put(AccessoryType.HEADSET, headset);
    }

    /**
     * Sets the audio system
     * @param audioSystem
     */
    public void setAudioSystem(String audioSystem) {
        accessories.put(AccessoryType.AUDIOSYSTEM, audioSystem);
    }

    /**
     * Returns all accessories as string
     * @return
     */
    public String getAccessories() {
        String result = "\n";

        for (HashMap.Entry<AccessoryType, String> entry : accessories.entrySet()) {
            result += "\t" + entry.getValue() + "\n";
        }

        return result;
    }

    /**
     * Returns computer class name. It allow to distinguish objects if we store them in one collection
     * @return Computer class name
     */
    public String getComputerClass() {
        return this.getClass().getSimpleName();
    }
}
