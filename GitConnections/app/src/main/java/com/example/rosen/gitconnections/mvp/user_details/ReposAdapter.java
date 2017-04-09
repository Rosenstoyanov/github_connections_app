package com.example.rosen.gitconnections.mvp.user_details;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.application.App;
import com.example.rosen.gitconnections.model.RepositoryDetails;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rosen on 09.04.17.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoHolder> {
    private ArrayList<RepositoryDetails> mData;

    public ReposAdapter() {
        this.mData = new ArrayList<>();
    }

    public void setData(ArrayList<RepositoryDetails> mData) {
        this.mData.clear();
        this.mData = mData;
    }

    @Override
    public RepoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepoHolder(LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.row_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(RepoHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    class RepoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        AppCompatTextView mTvName;
        @BindView(R.id.tv_description)
        AppCompatTextView mTvDescription;
        @BindView(R.id.tv_forks)
        AppCompatTextView mTvForks;
        @BindView(R.id.tv_watches)
        AppCompatTextView mTvWatches;

        public RepoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(RepositoryDetails repositoryDetails){
            mTvName.setText(repositoryDetails.getName());
            mTvDescription.setText(repositoryDetails.getDescription());
            mTvForks.setText(App.getInstance().getString(R.string.forks, repositoryDetails.getForksCount()));
            mTvWatches.setText(App.getInstance().getString(R.string.watches, repositoryDetails.getWatchersCount()));
        }
    }

}
