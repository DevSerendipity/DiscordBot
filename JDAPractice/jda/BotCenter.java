package DiscordBot.JDAPractice.jda;

import DiscordBot.JDAPractice.jda.command.Calculate;
import DiscordBot.JDAPractice.jda.command.Clear;
import DiscordBot.JDAPractice.jda.command.Image;
import DiscordBot.JDAPractice.jda.command.InviteCommand;
import DiscordBot.JDAPractice.jda.command.ServerInfo;
import DiscordBot.JDAPractice.jda.command.UserInfo;

import DiscordBot.JDAPractice.jda.events.Reactions;
import DiscordBot.JDAPractice.jda.events.WelcomeEvent;

import DiscordBot.JDAPractice.jda.filter.Filter;
import DiscordBot.JDAPractice.jda.filter.FilterMessage;
import DiscordBot.JDAPractice.jda.filter.FilterOnOff;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class BotCenter {

    public static String prefix = "!";
    public static JDA jda;

    public static void main(String[] args) throws LoginException {

        jda = new JDABuilder(AccountType.BOT).setToken("NzM3NjA0Njg0MTAxMDU4NjYw.Xx_x5A.0D9gV6bbD8IWDfB7N00shDnYl80").build();

        jda.addEventListener(new WelcomeEvent());
        jda.addEventListener(new Reactions());

        jda.addEventListener(new Filter());
        jda.addEventListener(new FilterMessage());
        jda.addEventListener(new FilterOnOff());

        jda.addEventListener(new Calculate());
        jda.addEventListener(new Clear());

        jda.addEventListener(new InviteCommand());
        jda.addEventListener(new UserInfo());

        jda.getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "YOU"));

        CommandClientBuilder builder = new CommandClientBuilder();

        builder.addCommand(new Image());
        builder.addCommand(new ServerInfo());

        builder.setOwnerId("586635708668837898");
        CommandClient client = builder.build();

        jda.addEventListener(client);
    }
}
