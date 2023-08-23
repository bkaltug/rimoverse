package com.example.rimoverse


import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rimoverse.fragments.CharacterListFragment
import com.example.rimoverse.fragments.CharacterListFragmentDirections
import com.example.rimoverse.models.Character
import com.squareup.picasso.Picasso
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Adapter(private val characterList: MutableList<Character>): RecyclerView.Adapter<CharacterListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list_item,parent,false)
        return CharacterListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        return holder.bindView(characterList[position])
    }
}

class CharacterListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


    private val listItemText : TextView = itemView.findViewById(R.id.characterNameTextView)
    private val listItemImage : ImageView = itemView.findViewById(R.id.characterImageView)
    fun bindView(character: Character){
        listItemImage.setOnClickListener{
            val action = CharacterListFragmentDirections.actionCharacterListFragment2ToCharacterDetailFragment().setCharacterId(character.id)
            findNavController(it.findFragment()).navigate(action)
        }
        listItemText.text = character.name
        Picasso.get().load(character.image).into(listItemImage)


    }
}