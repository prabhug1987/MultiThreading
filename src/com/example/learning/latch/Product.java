package com.example.learning.latch;

class Product {
	public int Id
	{ get; set; }
	public string Name
	{ get; set; }
	public double Price
	{ get; set; }
}

class Program {
	private static ConcurrentQueue<Product> _products = new ConcurrentQueue<Product>();

	static void Main(string[] args)
    {
        var source = new CancellationTokenSource();
        var token = source.Token;           
 
        Task.Run(() => {
            var conf = new Configuration();
            conf.Encoding = Encoding.UTF8;
            conf.CultureInfo = CultureInfo.InvariantCulture;
 
            using (var stream = File.OpenWrite("products.txt"))
            using (var streamWriter = new StreamWriter(stream))
            using (var writer = new CsvWriter(streamWriter, conf))
            {
                writer.WriteHeader<Product>();
                writer.NextRecord();
 
                while (true)
                {
                    if(token.IsCancellationRequested)
                    {
                        streamWriter.Flush();
                        return;
                    }
 
                    Product product = null;
 
                    while(_products.TryDequeue(out product))
                    {
                        writer.WriteRecord(product);
                        writer.NextRecord();
                    }
                }}},token);

	var task1 = Task.Run(() => 
        {
            foreach(var number
	in Enumerable.Range(1,10))
	{
                var product = new Product
                {
                    Id = number,
                    Name = "Product " + number,
                    Price = Math.Round((10d * number) / DateTime.Now.Second, 2)
                };
 
                _products.Enqueue(product);
 
                Task.Delay(150).Wait();
            }});

	var task2 = Task.Run(() => 
        {
            foreach (var number
	in Enumerable.Range(11,10))
	{
                var product = new Product
                {
                    Id = number,
                    Name = "Product " + number,
                    Price = Math.Round((10d * number) / DateTime.Now.Second, 2)
                };
 
                _products.Enqueue(product);
 
                Task.Delay(150).Wait();
            }
});

Task.WaitAll(task1,task2);

Console.WriteLine(Environment.NewLine);Console.WriteLine("Press any key to exit ...");Console.ReadKey();

source.Cancel();}}