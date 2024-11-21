package com.example.mytraveljournal.ui.home

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.mytraveljournal.R
import com.example.mytraveljournal.TravelData.Travel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class HomeFragmentDirections private constructor() {
  private data class ActionNavHomeToEditFragment(
    public val currentTravel: Travel,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_nav_home_to_editFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Travel::class.java)) {
          result.putParcelable("currentTravel", this.currentTravel as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Travel::class.java)) {
          result.putSerializable("currentTravel", this.currentTravel as Serializable)
        } else {
          throw UnsupportedOperationException(Travel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionNavHomeToEditFragment(currentTravel: Travel): NavDirections =
        ActionNavHomeToEditFragment(currentTravel)

    public fun actionNavHomeToAddFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_nav_home_to_addFragment)
  }
}
