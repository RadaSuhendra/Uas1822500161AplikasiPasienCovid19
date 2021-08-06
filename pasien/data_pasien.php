<?php
include 'koneksi.php';
$items = array();
$res = mysqli_query($con, "select * from pasien");
if (mysqli_num_rows($res) > 0){
while ($row = mysqli_fetch_object($res)){
	array_push($items, $row);
}
$result["pasien"] = $items;
}else{
	$result["pasien"] = "tidak ada data";
}
echo json_encode($result);

?>