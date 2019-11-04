<?php
$quadratic    = $_POST['quadratic'];
$linear       = $_POST['linear'];
$absolute     = $_POST['absolute'];
$equation     = $quadratic . 'x<sup>2</sup> ' . ' + ' . $linear . 'x ' . ' + '
  . $absolute;
$discriminant = ($linear * $linear) - (4 * $quadratic * $absolute);
$root1        = (-$linear + sqrt($quadratic)) / (2 * $quadratic);
$root2        = (-$linear - sqrt($quadratic)) / (2 * $quadratic);
?>

<h1 style="text-align: center">Řešení kvadratické rovnice</h1>
<hr>
<div style="text-align: center">
  <span style="font-weight: bold">Rovnice: </span><?= $equation ?><br>

  <span style="font-weight: bold">Kvadratický člen: </span><?= $quadratic ?>
	<br>
	<span style="font-weight: bold">Lineární člen: </span><?= $linear ?><br>
	<span style="font-weight: bold">Absolutní člen: </span><?= $absolute ?><br>
	<br>
	<span style="font-weight: bold">Diskriminant: </span><?= $discriminant ?>
	<br>
	<span style="font-weight: bold">Kořen 1: </span><?= $root1 ?><br>
  <span style="font-weight: bold">Kořen 2: </span><?= $root2 ?><br>
</div>
