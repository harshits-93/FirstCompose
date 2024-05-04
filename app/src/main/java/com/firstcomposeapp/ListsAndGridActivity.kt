package com.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme

class ListsAndGridActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //usingColumnWithScroll()
                    // usingLazyColumns()
                    usingGrids()
                }
            }
        }
    }

    @Composable
    private fun usingGrids() {
        //Use any one of these and comment others.


        // Two ways grid can be used, first is when we specify GridCells.Fixed(value), value repres
        //ents no. of column, so columns are fixed, so each gridcell size is adjusted accordingly
        //on different devices to maintain this condition.
        /*LazyVerticalGrid(columns = GridCells.Fixed(4)) {
            items(400) {
                Box(modifier = Modifier.background(Color.Cyan)) {
                    Text(it.toString())
                }
            }
        }*/

        //Second approach: GridCells.Adaptive(value), here in value we specify, how much length each
        //gridcell should be of. this length is now fixed, so number of columns can increase or
        //decrease based on available width of screen.
        /*LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {
            items(400) {
                Box(modifier = Modifier.background(Color.Cyan)) {
                    Text(it.toString())
                }
            }
        }*/

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(100.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(12.dp),
        ) {
            items(1000) {
                Box(modifier = Modifier.background(Color.Cyan)) {
                    Text(it.toString(), modifier = Modifier.align(Alignment.Center).padding(6.dp))
                }
            }
        }

        //Similarly if we want grid cells to scroll horizontally we use LazyHorizontalGrid

    }


    /*
    * The Lazy components are different to most layouts in Compose. Instead of accepting a @Composable content block parameter
    * , allowing apps to directly emit composables, the Lazy components provide a LazyListScope.() block. This LazyListScope block
    *  offers a DSL which allows apps to describe the item contents. The Lazy component is then responsible for adding the each item’s
    *  content as required by the layout and scroll position
    * */
    @Composable
    private fun usingLazyColumns() {
        //Here no need to add scroll and state,they are added by default.
        //Advantage of this is not all element are loaded at a time, but only visible element loaded
        // and few tiles for recycling. It is replaced of recyclerview which we used with xml
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {

            // Add a single item
            item {
                Text(
                    "hello", modifier = Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                )
            }


            val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 0, 0, 5, 5, 7, 7, 7, 8, 8, 8)

            // Add multiple items
            items(list.size) { index ->
                Text(
                    text = "Item at $index is ${list[index]}", fontSize = 24.sp,
                    modifier = Modifier
                        .background(Color.Magenta)
                        .padding(12.dp)
                        .fillMaxWidth()
                )
            }


            itemsIndexed(list) { index, item ->
                Text(
                    text = "Item at $index is $item", fontSize = 24.sp,
                    modifier = Modifier
                        .background(Color.Blue)
                        .padding(12.dp)
                )
            }

        }

    }

    @Composable
    private fun usingColumnWithScroll() {
        //Disadvantage of this approach is that it impacts memory. No matter what is the size
        //of list or number of element, they all will loaded all at once in memory
        val state = rememberScrollState()

        Column(
            modifier = Modifier
                .verticalScroll(state = state)
                .background(Color.Cyan)
        ) {
            for (i in 1..100) {
                Text(
                    text = "Item : $i",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(
                            Color.Magenta
                        )
                        .padding(12.dp)
                )
            }
        }
    }
}
