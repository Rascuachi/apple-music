package com.rascuache.apple_music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rascuache.apple_music.ui.theme.Apple_musicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppleMusicApp()
        }
    }
}

@Composable
fun AppleMusicApp() {
    Apple_musicTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black //color de fondo negro
        ) {
            Column {
                TopBar()
                Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el TopBar y el texto
                Text(
                    text = "Zuletzt hinzugefügt",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(20.dp)) // Espacio entre el texto y las imágenes
                Covers()
                BottomTab()
            }
        }
    }
}

@Composable
fun TopBar() {
    // Color código hexadecimal
    val backgroundColor = Color(0xFF1C1C1C)
    val bearbeitenColor = Color(0xFFA43B46)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(16.dp)
            .height(45.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(3f)) // Empuja "Mediathek" al centro
            Text(
                text = "Mediathek",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Bearbeiten",
                color = bearbeitenColor,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun Covers() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre filas
    ) {
        // Primera fila con 2 imágenes
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Portada 1
            AlbumCover(
                albumName = "midrift_EP",
                artistName = "midrift",
                imageResource = R.drawable.midrift
            )
            // Portada 2
            AlbumCover(
                albumName = "little_green_house",
                artistName = "anxious",
                imageResource = R.drawable.little_green_house
            )
        }

        // Segunda fila con 2 imágenes
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Portada 3
            AlbumCover(
                albumName = "awakening_EP",
                artistName = "zeruel",
                imageResource = R.drawable.awakening // Reemplaza con tu imagen
            )
            // Portada 4
            AlbumCover(
                albumName = "12th_house_rock",
                artistName = "narrow head",
                imageResource = R.drawable.house_rock // Reemplaza con tu imagen
            )
        }
        //Tercera fila con 2 imágenes
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween //espacio entre imagenes
        ) {
            // Portada 5
            AlbumCover(
                albumName = "la ultima noche",
                artistName = "austin tv",
                imageResource = R.drawable.ultima_noche
            )
            // Portada 6
            AlbumCover(
                albumName = "fake it flowers",
                artistName = "beabadoobee",
                imageResource = R.drawable.fake_it_flowers
            )
        }
    }
}

@Composable
fun AlbumCover(albumName: String, artistName: String, imageResource: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(180.dp) // Ancho de cada columna
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp) // Tamaño de portada
                .clip(RoundedCornerShape(8.dp)), // Borde redondeado
            contentScale = ContentScale.Crop // Ajustar la imagen al recuadro
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la imagen y el texto
        Text(
            text = albumName,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1 // Limita el texto a una línea
        )
        Text(
            text = artistName,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1 // Limita el texto a una línea
        )
    }
}
@Composable
fun BottomTab() {
    val backgroundColor = Color(0xFF4C5051)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .height(80.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start // Alinear a la izquierda
        ) {
            Image(
                painter = painterResource(id = R.drawable.congats), // Asegúrate de que este sea el nombre correcto
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp) // Tamaño pequeño para la imagen
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .padding(0.dp)
            ) {
                Text(
                    text = "follow you down",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 16.sp) // Ajusta lineHeight
                )
                Text(
                    text = "gin blossoms",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall.copy(lineHeight = 16.sp) // Ajusta lineHeight
                )
            }
        }
    }
}


