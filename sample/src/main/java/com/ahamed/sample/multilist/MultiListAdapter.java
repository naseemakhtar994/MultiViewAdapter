package com.ahamed.sample.multilist;

import android.content.Context;
import com.ahamed.multiviewadapter.DataListManager;
import com.ahamed.multiviewadapter.RecyclerAdapter;
import com.ahamed.multiviewadapter.SimpleItemDecoration;
import com.ahamed.sample.common.ThickItemDecorator;
import com.ahamed.sample.common.binder.BirdBinder;
import com.ahamed.sample.common.binder.FlowerBinder;
import com.ahamed.sample.common.model.Bird;
import com.ahamed.sample.common.model.Flower;
import java.util.List;

public class MultiListAdapter extends RecyclerAdapter {

  private DataListManager<Bird> birdDataManager;
  private DataListManager<Flower> flowerDataManager;

  public MultiListAdapter(Context context) {
    birdDataManager = new DataListManager<>(this);
    flowerDataManager = new DataListManager<>(this);

    addDataManager(birdDataManager);
    addDataManager(flowerDataManager);

    registerBinder(new BirdBinder(new ThickItemDecorator(context)));
    registerBinder(
        new FlowerBinder(new SimpleItemDecoration(context, SimpleItemDecoration.VERTICAL)));
  }

  public void addBirds(List<Bird> dataList) {
    birdDataManager.set(dataList);
  }

  public void addFlowers(List<Flower> dataList) {
    flowerDataManager.addAll(dataList);
  }
}
