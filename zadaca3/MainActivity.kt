package com.example.notesapp_msabo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NotesApp()
                }
            }
        }
    }
}

@Composable
fun NotesApp() {
    val navController = rememberNavController()
    val notesList = remember { mutableStateListOf<Note>() }

    NavHost(navController = navController, startDestination = "zaslon1") {

        composable("zaslon1") {
            Zaslon1(navController, notesList)
        }

        composable(
            route = "zaslon2?noteId={noteId}",
            arguments = listOf(navArgument("noteId") {
                nullable = true
                defaultValue = null
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")

            Zaslon2(navController, notesList, noteId)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Zaslon1(navController: NavController, notesList: MutableList<Note>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notes") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("zaslon2")
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Dodaj")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            items(notesList) { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable {
                            navController.navigate("zaslon2?noteId=${note.id}")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = note.naslov, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Zaslon2(navController: NavController, notesList: MutableList<Note>, noteId: String?) {

    var existingNote: Note? = null
    if (noteId != null) {
        for (n in notesList) {
            if (n.id == noteId) {
                existingNote = n
            }
        }
    }

    var naslov by remember { mutableStateOf(existingNote?.naslov ?: "") }
    var opis by remember { mutableStateOf(existingNote?.opis ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (existingNote == null) {
                        Text("Nova bilješka")
                    } else {
                        Text("Uredi bilješku")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Nazad")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize()) {
            OutlinedTextField(
                value = naslov,
                onValueChange = { naslov = it },
                label = { Text("Naslov") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = opis,
                onValueChange = { opis = it },
                label = { Text("Opis") },
                modifier = Modifier.fillMaxWidth().weight(1f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (existingNote != null) {
                        val index = notesList.indexOf(existingNote)
                        notesList[index] = existingNote.copy(naslov = naslov, opis = opis)
                    } else {
                        val novaBiljeska = Note(naslov = naslov, opis = opis)
                        notesList.add(novaBiljeska)
                    }
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Done")
            }
        }
    }
}