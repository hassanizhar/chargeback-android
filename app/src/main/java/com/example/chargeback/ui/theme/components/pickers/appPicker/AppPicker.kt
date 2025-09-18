package com.example.chargeback.ui.theme.components.pickers.appPicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chargeback.data.model.AppName
import com.example.chargeback.ui.theme.components.common.PickerHeader
import com.example.chargeback.ui.theme.components.common.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPickerSheet(
    apps: List<AppName>,
    selectedApp: AppName,
    onAppSelected: (AppName) -> Unit,
    onDismissRequest: () -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    val filteredApps = remember(searchText, apps) {
        if (searchText.isEmpty()) apps
        else apps.filter { it.displayName.lowercase().contains(searchText.lowercase()) }
    }

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            // Header
            PickerHeader(title = "App") {
                onDismissRequest()
            }

            // SearchBar from previous code
            SearchBar(
                searchText = searchText,
                onSearchTextChanged = { searchText = it }
            )

            // List of apps
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .heightIn(max = 400.dp) // like .medium/.large
            ) {
                items(filteredApps) { app ->
                    AppPickerItem(
                        app = app,
                        selectedApp = selectedApp,
                        onAppSelected = {
                            onAppSelected(app)
                        }
                    )
                }
            }
        }
    }
}