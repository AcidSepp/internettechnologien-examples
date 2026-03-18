package de.haw.landshut.itt;

import org.bson.BsonBinary;
import org.bson.BsonBinaryWriter;
import org.bson.BsonDocument;
import org.bson.BsonDouble;
import org.bson.BsonInt64;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.io.BasicOutputBuffer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Bson {
    public static void main(String[] args) throws Exception {
        final var document = new BsonDocument();
        document.append("aDouble", new BsonDouble(1337.42));
        document.append("anInt", new BsonInt64(133712345));
        document.append("someBytes", new BsonBinary(new byte[]{0xC, 0xA, 0xF, 0xE, 0xB, 0xA, 0xB, 0xE}));

        writeToFile(document, Path.of("build/numbers.bson"));
    }

    public static void writeToFile(BsonDocument doc, Path filePath) throws IOException {
        try (final var buffer = new BasicOutputBuffer();
             final var writer = new BsonBinaryWriter(buffer);
             final var out = new FileOutputStream(filePath.toFile())) {
            new BsonDocumentCodec().encode(writer,
                    doc,
                    EncoderContext.builder().isEncodingCollectibleDocument(true).build());
            out.write(buffer.toByteArray());
        }
    }
}
