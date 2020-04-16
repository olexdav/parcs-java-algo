import parcs.*;
import java.lang.Math;
import java.util.*;

public class Algo implements AM{
    public void run(AMInfo info){
        ArrayList<Integer> arr = (ArrayList<Integer>)info.parent.readObject();
        Collections.sort(arr);
        //if (range.size() == 0)
        //    result = new BigInteger("1");
        //else if (range.size() == 1)
        //    result = BigInteger.valueOf(range.get(0));
        //else {
        //    int parts = 2;
        //    int step = (int)(Math.ceil((float)(range.size()) / (float)(parts)));
        //    point[] points = new point[parts];
        //    channel[] channels = new channel[parts];
        //    for (int i = 0; i < parts; i++) { // Split tasks between workers
        //        int l, r;
        //        l = i*step;
        //        r = l + step;
        //        if (r > range.size())
        //            r = range.size();
        //        points[i] = info.createPoint();
        //        channels[i] = points[i].createChannel();
        //        points[i].execute("Algo");
        //        channels[i].write(new ArrayList<Integer>(range.subList(l, r)));
        //    }
        //    //result = 1; 
        //    result = new BigInteger("1"); // Gather results
        //    BigInteger channel_res = new BigInteger("1");
        //    for (int i = 0; i < parts; i++)
        //        channel_res = new BigInteger((String)channels[i].readObject());
        //        result = result.multiply(channel_res);
        //}
        
        //info.parent.write(String.valueOf(arr.size()));
        info.parent.write("Nice!");
    }
}
