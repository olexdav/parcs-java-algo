import parcs.*;
import java.lang.Math;
import java.util.*;

public class Algo implements AM{
    public void run(AMInfo info){
        ArrayList<Integer> arr = (ArrayList<Integer>)info.parent.readObject();
        Collections.sort(arr);
        info.parent.write("Nice!");
    }
}
