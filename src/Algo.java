import parcs.*;
import java.lang.Math;
import java.util.*;

public class Algo implements AM{
    public void run(AMInfo info){
        ArrayList<Integer> arr = (ArrayList<Integer>)info.parent.readObject();
        //Collections.sort(arr);
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (arr.size() == 0) {}
        else if (arr.size() == 1)
            result.add(arr.get(0));
        else {
            int parts = 2;
            int step = (int)(Math.ceil((float)(arr.size()) / (float)(parts)));
            point[] points = new point[parts];
            channel[] channels = new channel[parts];
            for (int i = 0; i < parts; i++) { // Split tasks between workers
                int l, r;
                l = i*step;
                r = l + step;
                if (r > arr.size())
                    r = arr.size();
                points[i] = info.createPoint();
                channels[i] = points[i].createChannel();
                points[i].execute("Algo");
                channels[i].write(new ArrayList<Integer>(arr.subList(l, r)));
            }
            // Gather results
            //ArrayList<Integer>[] channel_res = new ArrayList<Integer>[parts];// = new ArrayList<Integer>();
            //ArrayList<Integer>[] channel_res = (ArrayList<Integer>[]) new Object[parts];
            ArrayList<ArrayList<Integer>> channel_res = new ArrayList<ArrayList<Integer>>(parts);
            for (int i = 0; i < parts; i++)
                channel_res.add((ArrayList<Integer>)channels[i].readObject());
            while (true) {
                boolean anything_left = false;
                ArrayList<Integer> first = new ArrayList<>();
                for (int i = 0; i < parts; i++) {
                    if (channel_res.get(i).size() > 0) {
                        anything_left = true;
                        first.add(channel_res.get(i).get(0));
                    }
                    else first.add(9999999);
                }
                if (!anything_left)
                    break;
                int chosen = 0;
                for (int i = 1; i < parts; i++)
                    if (first.get(i) < first.get(chosen))
                        chosen = i;
                result.add(channel_res.get(chosen).remove(0));
            }
        }
        
        info.parent.write(result);
    }
}
