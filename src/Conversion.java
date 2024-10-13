public record Conversion(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {

    public String toString() {
        return String.format("\n-------------------------------\nConversion rate: 1 %s - %.3f %s\nResult: %.3f %s\n-------------------------------", this.base_code, this.conversion_rate, this.target_code, this.conversion_result, this.target_code);
    }

}
