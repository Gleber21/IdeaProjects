package Model.Writer;

import java.io.Serializable;

public interface Writable extends Readable{
    boolean save(Serializable serializable);
}
