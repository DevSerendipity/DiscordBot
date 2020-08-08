package DiscordBot.JDAPractice.jda;

import DiscordBot.JDAPractice.jda.command.Calculate;
import DiscordBot.JDAPractice.jda.command.Clear;
import DiscordBot.JDAPractice.jda.command.Image;
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

        jda = new JDABuilder(AccountType.BOT).setToken("NzM3NjA0Njg0MTAxMDU4NjYw.Xx_x5A.U1PQDA3-FLzau7GIQUKqK92gdSs").build();

        jda.addEventListener(new WelcomeEvent());
        jda.addEventListener(new Reactions());

        jda.addEventListener(new Filter());
        jda.addEventListener(new FilterMessage());
        jda.addEventListener(new FilterOnOff());

        jda.addEventListener(new Calculate());
        jda.addEventListener(new Clear());

        jda.getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "YOU"));

        CommandClientBuilder builder = new CommandClientBuilder();

        builder.addCommand(new Image());
        builder.setOwnerId("586635708668837898");
        CommandClient client = builder.build();

        jda.addEventListener(client);
    }
}
