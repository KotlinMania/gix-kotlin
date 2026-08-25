import Testing
import Gix

@Suite("Gix Export Smoke Tests")
struct GixExportTests {
    @Test("Swift module loads and instantiates types cleanly")
    func testSwiftModuleLoads() throws {
        let hex = "e69de29bb2d1d6434b8b29ae775ad8c2e48c5391"
        let oid = ObjectId.Companion.shared.fromHex(hex: hex)
        #expect(oid.toHex() == hex)
        #expect(!oid.isNull())

        let repo = Gix.shared.open(directory: "/tmp/repo")
        #expect(repo.workdir() == "/tmp/repo")
        #expect(repo.gitDir == "/tmp/repo/.git")
        #expect(!repo.isBare)

        let id = Id(inner: oid, repo: repo)
        #expect(id.shorten(length: 7) == "e69de29")
    }
}
