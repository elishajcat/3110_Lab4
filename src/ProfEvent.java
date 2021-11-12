import java.util.*;

public class ProfEvent extends EventObject{
    private final Date midtermDate;

    public ProfEvent(Date md, Prof p){
        super(p);
        midtermDate = md;
    }

    public Date getMidtermDate() {
        return this.midtermDate;
    }


    public Prof getProf() {
        return (Prof) this.getSource();
    }

}
