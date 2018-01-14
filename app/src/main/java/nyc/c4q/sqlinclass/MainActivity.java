package nyc.c4q.sqlinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nyc.c4q.sqlinclass.database.LaptopDatabaseHelper;
import nyc.c4q.sqlinclass.model.Laptop;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        LaptopDatabaseHelper laptopDatabaseHelper= new LaptopDatabaseHelper(getApplicationContext());

        laptopDatabaseHelper.addLaptop(new Laptop("Yoki", date, "blue", 4, "good"));
        laptopDatabaseHelper.addLaptop(new Laptop("Joanne", date, "silver", 2, "good"));
        laptopDatabaseHelper.addLaptop(new Laptop("Shantal", date, "black", 1, "bad"));
        laptopDatabaseHelper.addLaptop(new Laptop("Francisco", date, "silver", 3, "bad"));

        List<Laptop> laptops = laptopDatabaseHelper.getLaptopList();

        for(Laptop f : laptops) {
            Log.d("Fellows? ", f.getName() + " " + f.getColor() + " - " + f.getClassnumber()  + " - " + f.getCondition());
        }

    }
}
