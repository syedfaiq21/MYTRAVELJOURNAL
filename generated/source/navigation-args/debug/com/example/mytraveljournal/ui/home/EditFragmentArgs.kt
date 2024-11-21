package com.example.mytraveljournal.ui.home

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.mytraveljournal.TravelData.Travel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class EditFragmentArgs(
  public val currentTravel: Travel,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Travel::class.java)) {
      result.set("currentTravel", this.currentTravel as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Travel::class.java)) {
      result.set("currentTravel", this.currentTravel as Serializable)
    } else {
      throw UnsupportedOperationException(Travel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): EditFragmentArgs {
      bundle.setClassLoader(EditFragmentArgs::class.java.classLoader)
      val __currentTravel : Travel?
      if (bundle.containsKey("currentTravel")) {
        if (Parcelable::class.java.isAssignableFrom(Travel::class.java) ||
            Serializable::class.java.isAssignableFrom(Travel::class.java)) {
          __currentTravel = bundle.get("currentTravel") as Travel?
        } else {
          throw UnsupportedOperationException(Travel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentTravel == null) {
          throw IllegalArgumentException("Argument \"currentTravel\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentTravel\" is missing and does not have an android:defaultValue")
      }
      return EditFragmentArgs(__currentTravel)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EditFragmentArgs {
      val __currentTravel : Travel?
      if (savedStateHandle.contains("currentTravel")) {
        if (Parcelable::class.java.isAssignableFrom(Travel::class.java) ||
            Serializable::class.java.isAssignableFrom(Travel::class.java)) {
          __currentTravel = savedStateHandle.get<Travel?>("currentTravel")
        } else {
          throw UnsupportedOperationException(Travel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentTravel == null) {
          throw IllegalArgumentException("Argument \"currentTravel\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentTravel\" is missing and does not have an android:defaultValue")
      }
      return EditFragmentArgs(__currentTravel)
    }
  }
}
