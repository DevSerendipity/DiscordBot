package DiscordBot.JDAPractice.jda.command;

import DiscordBot.JDAPractice.jda.BotCenter;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Calculate extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] message = e.getMessage().getContentRaw().split(" ");
        //You have to use the same package to apply the BotCenter.prefix-

        if (message[0].equalsIgnoreCase(BotCenter.prefix + "calculate") && message.length == 1) {
            e.getChannel().sendMessage("To use this command type(without brackets): !calculate [add/sub] [mul/div] [first num] [second num]").queue();
        } else if (message[0].equalsIgnoreCase(BotCenter.prefix + "calculate") && message[1].equalsIgnoreCase("add")) {
            try {
                if (message.length == 4) {
                    int num1 = Integer.parseInt(message[2]);
                    int num2 = Integer.parseInt(message[3]);
                    e.getChannel().sendMessage("Here is the result: " + (num1 + num2)).queue();
                } else {
                    System.err.println("Nop you can not do that. Enter 2 numbers");
                    e.getChannel().sendMessage("```diff\n-We don't do that here, you can't enter only 2 numbers anything else = ERROR \n```").queue();
                }
            } catch (IndexOutOfBoundsException er) {
                er.printStackTrace();
                er.getCause().getMessage();
            }
        } else if (message[0].equalsIgnoreCase(BotCenter.prefix + "calculate") && message[1].equalsIgnoreCase("sub")) {
            try {
                if (message.length == 4) {
                    int num1 = Integer.parseInt(message[2]);
                    int num2 = Integer.parseInt(message[3]);
                    e.getChannel().sendMessage("Here is the result: " + (num1 - num2)).queue();
                } else {
                    System.err.println("Nop you can not do that. Enter 2 numbers");
                    e.getChannel().sendMessage("```diff\n-We don't do that here, you can't enter only 2 numbers anything else = ERROR \n```").queue();
                }
            } catch (IndexOutOfBoundsException er) {
                er.printStackTrace();
                er.getCause().getMessage();
            }
        } else if (message[0].equalsIgnoreCase(BotCenter.prefix + "calculate") && message[1].equalsIgnoreCase("mul")) {
            try {
                if (message.length == 4) {
                    int num1 = Integer.parseInt(message[2]);
                    int num2 = Integer.parseInt(message[3]);
                    e.getChannel().sendMessage("Here is the result: " + (num1 * num2)).queue();
                }else{
                    System.err.println("Nop you can not do that. Enter 2 numbers");
                    e.getChannel().sendMessage("```diff\n-We don't do that here, you can't enter only 2 numbers anything else = ERROR \n```").queue();
                }
            } catch (IndexOutOfBoundsException er) {
                er.printStackTrace();
                er.getCause().getMessage();
            }
        } else if (message[0].equalsIgnoreCase(BotCenter.prefix + "calculate") && message[1].equalsIgnoreCase("div")) {
            try {
                if (message.length == 4 && Integer.parseInt(message[2]) != 0 && Integer.parseInt(message[3]) != 0) {
                    int num1 = Integer.parseInt(message[2]);
                    int num2 = Integer.parseInt(message[3]);
                    e.getChannel().sendMessage("Here is the result: " + (num1 / num2)).queue();
                } else if (message.length == 4 && Integer.parseInt(message[2]) == 0 && Integer.parseInt(message[3]) != 0) {
                    int num1 = Integer.parseInt(message[2]);
                    int num2 = Integer.parseInt(message[3]);
                    e.getChannel().sendMessage("Here is the result: " + (num1 / num2)).queue();
                } else if (message.length == 4 && Integer.parseInt(message[2]) != 0 && Integer.parseInt(message[3]) == 0) {
                    System.err.println("Nop you can not do that. Enter 2 numbers");
                    e.getChannel().sendMessage("```diff\n-We don't do that here, you can't enter only 2 numbers anything else = ERROR \n```").queue();
                }
                else{
                    System.err.println("Nop you can not do that. Enter 2 numbers");
                    e.getChannel().sendMessage("```diff\n-We don't do that here, you can't enter only 2 numbers anything else = ERROR \n```").queue();
                }
            }catch (IndexOutOfBoundsException er) {
                er.printStackTrace();
                er.getCause().getMessage();
            }
        }
    }
}