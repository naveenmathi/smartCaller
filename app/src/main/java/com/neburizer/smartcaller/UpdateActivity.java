package com.neburizer.smartcaller;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class UpdateActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void functionUpdateSettings(View v)
    {
        NumberPicker np = (NumberPicker)v.findViewById(R.id.numberPicker);
        int npVals=np.getValue();
        HashMap<String,String>[] days = new HashMap[np.getValue()];
        days[0].put("9898989898","13");
        days[0].put("8787878787","15");
        days[0].put("7676767676", "18");

        days[1].put("9898989898", "13");
        days[1].put("7676767676", "18");

        days[2].put("9898989898", "13");
        days[2].put("8787878787", "15");
        days[2].put("7676767676", "21");
        Iterator it = days[npVals-1].entrySet().iterator();
        ArrayList<String> passed = new ArrayList<String>();
        while(it.hasNext())
        {
            Map.Entry E = (Map.Entry)it.next();
            String key = (String) E.getKey();
            String val = (String) E.getValue();
            boolean flagVal = false;
            for(int d=npVals-2;d>-1;d++)
            {
                HashMap<String,String> tempDay = days[d];
                if(tempDay.containsKey(key))
                {
                    String tempVal = tempDay.get(key);
                    if(tempVal.equals(val)){
                       flagVal = true;
                       continue;
                    }
                }
                else{
                    flagVal = false;
                    break;
                }
            }
            if (flagVal)
            {
                passed.add(key);
            }
        }
    }
}/*
import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;


public class mc{
    public static void main(String a[]){
        //NumberPicker np = (NumberPicker)v.findViewById(R.id.numberPicker);
        int npVals=2;
        HashMap<String,String>[] days = new HashMap[npVals+1];
        for(int j=0;j<=npVals;j++)
            days[j]= new HashMap<String,String>();
        days[0].put("9898989898","13");
        days[0].put("8787878787","15");
        days[0].put("7676767676", "18");

        days[1].put("9898989898", "13");
        days[1].put("7676767676", "18");

        days[2].put("9898989898", "13");
        days[2].put("8787878787", "15");
        days[2].put("7676767676", "21");
        Iterator it = days[npVals-1].entrySet().iterator();
        ArrayList<String> passed = new ArrayList<String>();
        while(it.hasNext())
        {
            Map.Entry E = (Map.Entry)it.next();
            String key = (String) E.getKey();
            String val = (String) E.getValue();
            boolean flagVal = false;
            for(int d=npVals;d>-1;d--)
            {
                HashMap<String,String> tempDay = days[d];
                if(tempDay.containsKey(key))
                {
                    String tempVal = tempDay.get(key);
                    if(tempVal.equals(val)){
                        flagVal = true;
                        continue;
                    }
                    else
                    {
                        flagVal=false;
                        break;
                    }
                }
                else{
                    flagVal = false;
                    break;
                }
            }
            if (flagVal)
            {
                passed.add(key);
            }
        }
        System.out.println(" passed = "+passed.toString());
    }
}*/