package io.rohail.recyclerbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(),
    BindableAdapter<List<Long>> {

    var userIds = emptyList<Long>()

    override fun setData(items: List<Long>) {
        userIds = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount() = userIds.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userIds[position])
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(userId: Long) {
            itemView.userText.text = "User id: $userId"
        }
    }

}