# Fix Multiple Scroll views on the same screen
Example that show how to fix the problem of scroll inside scroll using view pager, nestedScrollView, fragments and coordinator layout

The key points that fix the problem of view pager not been shown inside a nestedScrollView or ScrollView is to use a coordinator layout as the parent of the view pager and use nestedScrollView only inside the fragments and also remove the scroll of the recyclerview to fix the slow scroll conflicts by doing yourRecyclerView.setNestedScrollingEnabled(false);

<img src="https://i.imgur.com/tfBhei3.png" height="500px" width="240px">  <img src="https://i.imgur.com/SzZ9Mgv.png" height="500px" width="240px">

So the hierarchy will be:
---
Main hierarchy
```
<CoordinatorLayout>     
    <AppBarLayout>
        <LinearLayout app:layout_scrollFlags="scroll"> 
           -- Header above the view pager that you want to be scrolled
        </Linearlayout>
    </AppBarLayout>

    <LinearLayout app:layout_behavior="@string/appbar_scrolling_view_behavior">
        <TabLayout/>
        <ViewPager/>
    </LinearLayout>
</CoordinatorLayout>
```
---
Your fragment layout hierarchy, considering that it will have two recylerview inside.
```
<NestedScrollView android:fillViewport="true"> -- fillViewport to show the whole view pager
  <LinearLayout> -- Multiple recycler view needs a view group as the nestedScrollView can hold just one child
      <RecyclerView/> -- needs the key android:nestedScrollingEnabled="false" in the xml or set programatically
      <RecyclerView/> -- needs the key android:nestedScrollingEnabled="false" in the xml or set programatically
  </LinearLayout>
</NestedScrollView>
```

