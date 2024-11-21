package com.example.mytraveljournal.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.mytraveljournal.R

public class EditFragmentDirections private constructor() {
  public companion object {
    public fun actionEditFragmentToNavHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_editFragment_to_nav_home)
  }
}
