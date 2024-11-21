package com.example.mytraveljournal.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.mytraveljournal.R

public class AddFragmentDirections private constructor() {
  public companion object {
    public fun actionAddFragmentToNavHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addFragment_to_nav_home)
  }
}
