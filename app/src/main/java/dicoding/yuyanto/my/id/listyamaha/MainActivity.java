package dicoding.yuyanto.my.id.listyamaha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import dicoding.yuyanto.my.id.listyamaha.Models.BikeData;
import dicoding.yuyanto.my.id.listyamaha.Models.Bikes;
import dicoding.yuyanto.my.id.listyamaha.Models.ListBikeAdapter;



public class MainActivity extends AppCompatActivity {

    public static final String SELECTED_BIKE = "dicoding.yuyanto.my.id.listyamaha.MESSAGE.SELECTED_BIKE";


    private RecyclerView rvCategory;
    private ArrayList<Bikes> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(BikeData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListBikeAdapter listBikeAdapter = new ListBikeAdapter(list);
        rvCategory.setAdapter(listBikeAdapter);

        listBikeAdapter.setOnItemClickCallback(new ListBikeAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bikes data) {
                showSelectedHero(data);
            }
        });
    }
    private void showSelectedHero(Bikes bike) {
//        Toast.makeText(this, "Kamu memilih " + bike.getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, BikeDetailActivity.class);
        intent.putExtra(SELECTED_BIKE, bike.getName());
        startActivity(intent);

    }
}
