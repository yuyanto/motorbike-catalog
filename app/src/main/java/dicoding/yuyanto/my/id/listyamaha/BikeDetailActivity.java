package dicoding.yuyanto.my.id.listyamaha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import dicoding.yuyanto.my.id.listyamaha.Models.BikeData;
import dicoding.yuyanto.my.id.listyamaha.Models.Bikes;

public class BikeDetailActivity extends AppCompatActivity {
    private ArrayList<Bikes> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_detail);


        list.addAll(BikeData.getListData());

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.SELECTED_BIKE);

        Bikes SelectedBike = list.stream().filter( bike -> message.equals(bike.getName()) ).findAny().orElse(null);

        ImageView mainImage = findViewById(R.id.detailbikeImage);

        ImageView detailImage1 = findViewById(R.id.detailsmallImage1);

        ImageView detailImage2 = findViewById(R.id.detailsmallImage2);

        ImageView detailImage3 = findViewById(R.id.detailsmallImage3);


        TextView detailDesc = findViewById(R.id.detailbikedesc);

        TextView bikename = findViewById(R.id.bikeNameT);

        TextView bikespec = findViewById(R.id.bikespec);


        Glide.with(this)
                .load(SelectedBike.getPhoto())
                .apply(new RequestOptions().override(100, 100))
                .into(mainImage);


        Glide.with(this)
                .load(SelectedBike.getImage1())
                .apply(new RequestOptions().override(100, 100))
                .into(detailImage1);

        Glide.with(this)
                .load(SelectedBike.getImage2())
                .apply(new RequestOptions().override(100, 100))
                .into(detailImage2);


        Glide.with(this)
                .load(SelectedBike.getImage3())
                .apply(new RequestOptions().override(100, 100))
                .into(detailImage3);



        detailDesc.setText(SelectedBike.getDesc());
        bikename.setText(SelectedBike.getName() +"\n" + SelectedBike.getPrice());
        bikespec.setText(SelectedBike.getSpec());


        detailDesc.setMovementMethod(new ScrollingMovementMethod());
        bikespec.setMovementMethod(new ScrollingMovementMethod());
//
//
//
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(message);

    }
}
