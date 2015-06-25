# Setup

In app build.gradle,

    dependencies {
        ...
        compile 'com.android.support:design:22.2.0'
    }

# Show snackbar

    Snackbar.make(view, "Hello world",Snackbar.LENGTH_LONG).show();

# Set snackbar action

    snackbar.setAction("Undo", new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // Do something
        }
    });

# Integrate snackbar to floating action button

    coordinator_layout = findViewById(R.id.coordinatorlayout);
    Snackbar.make(coordinator_layout, "Hi", Snackbar.LENGTH_LONG).show();

# Customize snackbar styling

In stlyings.xml,

    <style name="Widget.Design.Snackbar" parent="android:Widget">
        <item name="android:background">#00FF00</item>
    </style>

<PROJECT_ROOT>/build/intermediates/exploded-aar/com.android.support/design/22.2.0/res/values/values.xml

# Reference
- [Snackbars design guidelines](https://goo.gl/4RV4kB)
- [Snackbar | Android Developers](http://goo.gl/1PwJuc)
