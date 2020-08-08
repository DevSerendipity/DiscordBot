package DiscordBot.JDAPractice.jda.command;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.coobird.thumbnailator.Thumbnails;

import java.io.ByteArrayOutputStream;
import java.net.URL;

public class Image extends Command {
    public Image() {
        this.name = "image";
        this.arguments = "[width] [height] [image-url] [degrees to rotate(optional)]"; //arguments shown in $helpme
        this.cooldown = 4;
        this.help = "Manipulates images. Provide an image link and you can resize and or rotate it.";
    }

    @Override
    protected void execute(CommandEvent e) {
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message[1].equalsIgnoreCase("image") && message.length == 2) {
            e.reply("You did not provide any arguments, " + e.getAuthor().getAsMention());
            e.reply("To use the Image Manipulator, type the command like this(without brackets]: \nimage [width] [height] [image-url] [degrees to rotate(optional)]");
        } else {
            try {
                int width = Integer.parseInt(message[2]);
                int height = Integer.parseInt(message[3]);
                URL imageURL = new URL(message[4]);
                int rotateAmount = 0;
                if (message.length == 6) { //Checks to see if they provided the optional rotation amount
                    rotateAmount = Integer.parseInt(message[5]);
                }
                ByteArrayOutputStream os = new ByteArrayOutputStream(); //Makes a new outputstream to be used to send the new image once it has been manipulated on the next line of code
                Thumbnails.of(imageURL).forceSize(width, height).rotate(rotateAmount).outputFormat("png").toOutputStream(os); //takes the image, does things to it, sends to our output stream
                byte[] imageInByte = os.toByteArray(); //Converts the ByteArrayOutputStream to an actual Byte Array so we can send a file using discord java api
                e.getChannel().sendFile(imageInByte, "YT.png").complete(); //Sends image in chat
                //Image sent
                e.reply(e.getAuthor().getAsMention() + ", here is your new image!!! It has been resized to: " + width + "x" + height + " and rotated to " + rotateAmount + "°");
            } catch (Exception ex) {
                System.out.println("Some exception happened. oops");
            }
        }
    }
}
