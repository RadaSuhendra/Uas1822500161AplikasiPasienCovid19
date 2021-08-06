<?php

 /*
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nama = $_POST['nama'];
		$gejala = $_POST['gejala'];
		$alamat = $_POST['alamat'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO pasien (Nama,Gejala,Alamat) VALUES ('$nama','$gejala','$alamat')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pasien';
		}else{
			echo 'Gagal Menambahkan Pasien';
		}
		
		mysqli_close($con);
	}
?>