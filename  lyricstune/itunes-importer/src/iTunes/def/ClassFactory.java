package iTunes.def  ;

import com4j.COM4J;

/**
 * Defines methods to create COM objects
 */
public abstract class ClassFactory {
    private ClassFactory() {} // instanciation is not allowed


    /**
     * iTunesApp Class
     */
    public static iTunes.def.IiTunes createiTunesApp() {
        return COM4J.createInstance( iTunes.def.IiTunes.class, "{DC0C2640-1415-4644-875C-6F4D769839BA}" );
    }
}
