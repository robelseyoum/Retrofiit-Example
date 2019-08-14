package com.robelseyoum3.retrofitexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.robelseyoum3.retrofitexample.model.GithubRepoModel;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<GithubRepoModel> repoList;

    public RepoAdapter(List<GithubRepoModel> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_layout, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {

        GithubRepoModel listrepo = repoList.get(position);

        holder.tv_names.setText(listrepo.getName());
        holder.tv_OwnerLog.setText(listrepo.getOwner().getLogin());
        holder.tv_Id.setText(""+listrepo.getId());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }


    public class RepoViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_names, tv_OwnerLog, tv_Id;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_names = itemView.findViewById(R.id.tv_name);
            this.tv_OwnerLog = itemView.findViewById(R.id.tv_login);
            this.tv_Id = itemView.findViewById(R.id.tv_id);

        }
    }
}
