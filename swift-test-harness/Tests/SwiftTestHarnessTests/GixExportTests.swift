import Testing
import Gix

@Suite("Gix Export Smoke Tests")
struct GixExportTests {
    @Test("Swift module loads cleanly")
    func testSwiftModuleLoads() throws {
        #expect(true)
    }
}
