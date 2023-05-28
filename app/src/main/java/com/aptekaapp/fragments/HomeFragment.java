package com.aptekaapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aptekaapp.R;
import com.aptekaapp.adapters.CategoryAdapter;
import com.aptekaapp.adapters.NewProductsAdapter;
import com.aptekaapp.models.CategoryModel;
import com.aptekaapp.models.NewProductModel;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView catRecyclerview, newProductRecyclerview;
    //Category recyclerView
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    //New product Recyclerview
    NewProductsAdapter newProductsAdapter;
    List<NewProductModel> newProductModelList;


    //FireStore
    FirebaseFirestore db;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        catRecyclerview = root.findViewById(R.id.rec_category);
        newProductRecyclerview = root.findViewById(R.id.new_product_rec);

        db = FirebaseFirestore.getInstance();

        // image slider

        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banner1, "Najlepsza na potencje", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner2, "Podejrzewasz swoje dziecko?", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner3, "10% zniżki na drugie opakowanie Ibuprom", ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(slideModels);


        //Category

        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        categoryModelList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext(), categoryModelList);
        catRecyclerview.setAdapter(categoryAdapter);
        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                CategoryModel categoryModel = document.toObject(CategoryModel.class);
                                categoryModelList.add(categoryModel);
                                categoryAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), ""+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //New Products

        newProductRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        newProductModelList = new ArrayList<>();
        newProductsAdapter = new NewProductsAdapter(getContext(), newProductModelList);
        newProductRecyclerview.setAdapter(newProductsAdapter);

        db.collection("NewProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                NewProductModel newProductModel = document.toObject(NewProductModel.class);
                                newProductModelList.add(newProductModel);
                                newProductsAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(), ""+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return root;
    }
}