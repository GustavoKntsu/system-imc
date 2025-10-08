package org.systemimc.Utils;

import java.nio.file.Paths;

public class PathFXML {
    public static String pathFXML(){
        String path = "src/main/java/org/systemimc/Views";
        return Paths.get(path).toAbsolutePath().toString();
    }

}
