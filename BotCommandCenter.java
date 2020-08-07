package DiscordBot;

import bot.events.WelcomeEvent;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class BotCommandCenter {
    public static String prefix = "!";
    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("NzM3NjA0Njg0MTAxMDU4NjYw.Xx_x5A.npiNIVa_UbPwdt7Tpw8tmRcVYBE").build();

        jda.addEventListener(new WelcomeEvent());

        jda.getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "YOU"));
    }
}