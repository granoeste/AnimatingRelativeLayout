AnimatingRelativeLayout
=========

This is a library of Animating RelativeLayout.

Add to project
--------

### build.gradle

```groovy
allprojects {
    // ...
    repositories {
        // ...
        maven { url 'https://granoeste.github.io/AnimatingRelativeLayout/repository' }
    }
}
```

### app/build.gradle

```groovy
apply plugin: 'com.android.application'

android {
  // ...
}

dependencies {
    compile 'net.granoeste:AnimatingRelativeLayout:0.1.0'
}
```

Usage
---

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

        <net.granoeste.animatingrelativelayout.widget.AnimatingRelativeLayout
            android:id="@+id/firstly"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:inAnimation="@android:anim/slide_in_left"
            app:outAnimation="@android:anim/slide_out_right" />

        <net.granoeste.animatingrelativelayout.widget.AnimatingRelativeLayout
            android:id="@+id/secondly"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:inAnimation="@android:anim/slide_in_left"
            app:outAnimation="@android:anim/slide_out_right" />

</LinearLayout>
```

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        firstly = (AnimatingRelativeLayout) findViewById(R.id.firstly);
        secondly = (AnimatingRelativeLayout) findViewById(R.id.secondly);
    }


    private void toggle() {
        if (firstly.isVisible()) {
            firstly.hide();
            secondly.show();
        } else if (secondly.isVisible()) {
            secondly.hide();
            thirdly.show();
        }
    }


```