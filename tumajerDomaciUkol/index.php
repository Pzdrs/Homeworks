<!doctype html>
<html lang="en">
<head>
  <?php
  $connection = NULL;
  try {
    $connection
      = new PDO('mysql:host=localhost;dbname=tumicka',
      'root', 'root');
  } catch
  (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
  }
  ?>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/bootstrap.css">
	<title>Tumajer domaci ukol</title>
</head>
<body>
<div class="container-fluid">
	<div class="row bg-danger text-center">
		<div class="col-12">
          <?php include 'includes/navigation.php'; ?>
		</div>
	</div>
	<div class="row">
		<div class="col-8">
			<h1 class="text-center">Novinky</h1>
			<hr>
			<div class="container-fluid mb-5">
              <?php
              $statement = $connection->prepare('SELECT * FROM news');
              $statement->execute();
              $result = $statement->fetchAll();

              foreach ($result as $item) {
                echo '<div class="row mb-3">'
                  . '<div style="border: 1px solid black" class="col-12"><h5 class="text-center">'
                  . $item['title']
                  . '</h5><hr><b>'
                  . $item['author'] . ' | ' . $item['date'] . '</b><br><br>'
                  . $item['content']
                  . '</div>'
                  . '</div>';
              }
              ?>
			</div>
		</div>
		<div class="col-4 text-center">
			<h1 class="text-center">Seznam novinek</h1>
			<hr>
          <?php
          $statement = $connection->prepare('SELECT title FROM news');
          $statement->execute();
          $result = $statement->fetchAll();

          foreach ($result as $item) {
            echo '<a href="#">'
              . $item['title']
              .'</a><br>';
          }
          ?>
		</div>
	</div>
	<div class="row bg-danger text-center">
		<div class="col-12">
          <?php include 'includes/footer.php'; ?>
		</div>
	</div>
</div>
</body>
</html>