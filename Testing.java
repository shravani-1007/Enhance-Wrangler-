@Test
public void testByteSize() {
    Assert.assertEquals(10485760L, new ByteSize("10MB").getBytes());
}

@Test
public void testTimeDuration() {
    Assert.assertEquals(120000, new TimeDuration("2m").getMilliseconds());
}


@Test
public void testAggregateStats() throws Exception {
    List<Row> rows = Arrays.asList(
        new Row().add("data", "10MB").add("time", "2s"),
        new Row().add("data", "5MB").add("time", "3s")
    );
    String[] recipe = {
        "aggregate-stats :data :time total_mb total_sec"
    };
    List<Row> result = TestingRig.execute(recipe, rows);

    Assert.assertEquals(1, result.size());
    Assert.assertEquals(15.0, (double) result.get(0).getValue("total_mb"), 0.001);
    Assert.assertEquals(5.0, (double) result.get(0).getValue("total_sec"), 0.001);
}
