package org.scoula.cli;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.scoula.cli.command.Command;

@Getter
@AllArgsConstructor
public class MenuItem {
    private String title;
    private Command command;
}
