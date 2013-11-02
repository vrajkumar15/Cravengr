package com.codepath.apps.cravengr;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.codepath.apps.cravengr.models.Business;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BusinessAdapter extends ArrayAdapter<Business> {

	public BusinessAdapter(Context context, List<Business> businesses) {
		super(context, 0, businesses);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if(view == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.business_item, null);
		}
		
		Business business = getItem(position);
		ImageView imageView = (ImageView) view.findViewById(R.id.ivBusiness);
		ImageLoader.getInstance().displayImage(business.getImageUrl(), imageView);
		
		TextView nameView = (TextView) view.findViewById(R.id.tvName);
		String formattedName =  business.getName();
		nameView.setText(Html.fromHtml(formattedName));
		
		TextView phone = (TextView) view.findViewById(R.id.tvPhone);
		phone.setText(Html.fromHtml(business.getPhone()));
		
		ImageView ratingView = (ImageView) view.findViewById(R.id.ivRating);
		ImageLoader.getInstance().displayImage(business.getRatingUrl(), ratingView);

		
		return view;
		
	}

}
